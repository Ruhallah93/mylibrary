package com.ahmadian.ruhallah.commons.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ahmadian.ruhallah.commons.R;
import com.ahmadian.ruhallah.commons.application.CommonsConfiguration;
import com.ahmadian.ruhallah.commons.utils.text.TextUtils;

/**
 * Created by ruhallah-PC on 10/3/2016.
 */

public class SmartTextView extends TextView {

    private int font;
    private String highlightKey;
    private int highlightColor;

    public SmartTextView(Context context) {
        super(context);
        init();
    }

    public SmartTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public SmartTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(defStyleAttr, R.styleable.SmartTextView);

        try {
            font = typedArray.getResourceId(R.styleable.SmartTextView_font, 0);
            highlightKey = typedArray.getString(R.styleable.SmartTextView_highlight_key);
            highlightColor = typedArray.getResourceId(R.styleable.SmartTextView_highlight_color, Color.YELLOW);
        }finally {
            typedArray.recycle();
        }

        init();
    }

    private void init() {
        if (isInEditMode())
            return;

        this.setTypeface(CommonsConfiguration.getTypeface(font));
    }

    protected void highlight() {
        Spanned highlightedSpan = new SpannableString(getText());
        highlightedSpan = TextUtils.find(getText(), highlightKey, highlightColor);
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public String getHighlightKey() {
        return highlightKey;
    }

    public void setHighlightKey(String highlightKey) {
        this.highlightKey = highlightKey;
    }
}