package com.ahmadian.ruhallah.commons.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.ahmadian.ruhallah.commons.R;
import com.ahmadian.ruhallah.commons.utils.text.Typefaces;

/**
 * Created by ruhallah-PC on 12/12/2016.
 */

public class SmartCheckBox extends CheckBox {
    private String font;

    public SmartCheckBox(Context context) {
        super(context);

        init();
    }

    public SmartCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmartCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SmartCheckedTextView, 0, 0);

        try {
            font = typedArray.getString(R.styleable.SmartCheckedTextView_smart_font);
        } finally {
            typedArray.recycle();
        }

        init();
    }

    private void init() {
        if (isInEditMode())
            return;

        this.setTypeface(Typefaces.get(getContext(), font));
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
}
