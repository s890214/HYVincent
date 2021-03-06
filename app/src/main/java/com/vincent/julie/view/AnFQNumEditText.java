package com.vincent.julie.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vincent.julie.R;
import com.vincent.julie.app.MyApplication;
import com.vincent.julie.listener.SendMsgOnClickListener;
import com.vincent.julie.util.ToastUtils;

/**
 * 项目名称：Julie
 * 类名：com.vincent.julie.view
 * 类描述：http://gold.xitu.io/post/57fb97412e958a005596cab9
 * 创建人：Vincent QQ:1032006226
 * 创建时间：2016/10/14 15:39
 * 修改人：
 * 修改时间：
 * 修改备注：
 * 十月
 */

public  class AnFQNumEditText extends RelativeLayout {
    //类型1(单数类型)：TextView显示总字数，然后根据输入递减.例：100，99，98
    //类型2(百分比类型)：TextView显示总字数和当前输入的字数，例：0/100，1/100，2/100
    public static final String SINGULAR = "Singular";//类型1(单数类型)
    public static final String PERCENTAGE = "Percentage";//类型2(百分比类型)
    private EditText etContent;//文本框
    private TextView tvSend;//发送按钮
    private TextView tvNum;//字数显示TextView
    private View vLine;//底部横线
    private String TYPES = SINGULAR;//类型
    private int MaxNum = 100;//最大字符

    private SendMsgOnClickListener sendMsgOnClickListener;

    public void setSendMsgListener(SendMsgOnClickListener sendMsgOnClickListener){
        this.sendMsgOnClickListener=sendMsgOnClickListener;
    }

    public AnFQNumEditText(Context context) {
        this(context, null);
    }

    public AnFQNumEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.anfq_num_editext, this, true);
        etContent = (EditText) findViewById(R.id.etContent);
        tvSend=(TextView)findViewById(R.id.tv_send_msg);
        tvNum = (TextView) findViewById(R.id.tvNum);
        vLine = findViewById(R.id.vLine);
    }

    /**
     * 设置发送按钮的文字，默认为短信发送
     * @param text
     */
    public void setText(String text){
        if(text!=null&&tvSend!=null){
            tvSend.setText(text);
        }
    }

    /**
     * 清空输入
     */
    public void clearText(){
        if(etContent!=null)etContent.setText("");
    }

    /**
     * 返回内容
     * @return
     */
    public String getText(){
        if(null!=etContent){
            return etContent.getText().toString().trim();
        }
        return null;
    }

    /**
     * 设置显示
     * @return
     */
    public AnFQNumEditText show(){
        if(TYPES.equals(SINGULAR)){//类型1
            tvNum.setText(String.valueOf(MaxNum));
        }else if(TYPES.equals(PERCENTAGE)){//类型2
            tvNum.setText(0+"/"+MaxNum);
        }
        //设置长度
        etContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MaxNum)});
        //监听输入
        etContent.addTextChangedListener(mTextWatcher);
        return this;
    }



    /**
     * 设置横线颜色
     * @param color --颜色值
     * @return
     */
    public AnFQNumEditText setLineColor(String color){
        vLine.setBackgroundColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置类型
     * @param type --类型
     * @return
     */
    public AnFQNumEditText setType(String type){
        TYPES = type;
        return this;
    }

    /**
     * 设置最大字数
     * @param num --字数
     * @return
     */
    public AnFQNumEditText setLength(int num){
        this.MaxNum = num;
        return this;
    }

    /**
     * 设置文本框的Hint
     * @param str --设置内容
     * @return
     */
    public AnFQNumEditText setEtHint(String str){
        etContent.setHint(str);
        return this;
    }

    /**
     * 设置文本框的最小高度
     * @param px --最小高度(单位px)
     * @return
     */
    public AnFQNumEditText setEtMinHeight(int px){
        etContent.setMinHeight(px);
        return this;
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        private int editStart;
        private int editEnd;

        public void afterTextChanged(Editable s) {
            editStart = etContent.getSelectionStart();
            editEnd = etContent.getSelectionEnd();
            // 先去掉监听器，否则会出现栈溢出
            etContent.removeTextChangedListener(mTextWatcher);
            // 注意这里只能每次都对整个EditText的内容求长度，不能对删除的单个字符求长度
            // 因为是中英文混合，单个字符而言，calculateLength函数都会返回1
            while (calculateLength(s.toString()) > MaxNum) { // 当输入字符个数超过限制的大小时，进行截断操作
                s.delete(editStart - 1, editEnd);
                editStart--;
                editEnd--;
            }
            // 恢复监听器
            etContent.addTextChangedListener(mTextWatcher);
            setLeftCount();
        }
        public void beforeTextChanged(CharSequence s, int start, int count,int after) {
        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void onTextChanged(CharSequence s, int start, int before,int count) {
            if (etContent.getText().length() == start && start == 0) {
                tvSend.setClickable(false);
                tvSend.setBackground(getResources().getDrawable(R.drawable.shape_tv_no_send_msg));
            } else {
                tvSend.setClickable(true);
                tvSend.setBackground(getResources().getDrawable(R.drawable.shape_tv_can_send_msg));
                tvSend.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendMsgOnClickListener.SendMsg(etContent.getText().toString());
                    }
                });
            }
        }
    };

    /** 刷新剩余输入字数 */
    private void setLeftCount() {
        if(TYPES.equals(SINGULAR)){//类型1
            tvNum.setText(String.valueOf((MaxNum - getInputCount())));
        }else if(TYPES.equals(PERCENTAGE)){//类型2
            tvNum.setText(MaxNum-(MaxNum - getInputCount())+"/"+MaxNum);
        }
    }



    /** 获取用户输入内容字数 */
    private long getInputCount() {
        return calculateLength(etContent.getText().toString());
    }



    /**
     * 计算分享内容的字数，一个汉字=两个英文字母，一个中文标点=两个英文标点
     * 注意：该函数的不适用于对单个字符进行计算，因为单个字符四舍五入后都是1
     * @param cs
     * @return
     */
    public static long calculateLength(CharSequence cs) {
        double len = 0;
        for (int i = 0; i < cs.length(); i++) {
            int tmp = (int) cs.charAt(i);
            if (tmp > 0 && tmp < 127) {
                len += 1;
            } else {
                len++;
            }
        }
        return Math.round(len);
    }
}
