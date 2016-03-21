package com.avatar.rxjava.view.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avatar.rxjava.R;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 16:55
 */
public class BaseView<T extends View> {
    protected T view;
    protected int layoutId;
    private Context context;

    public BaseView(T view) {
        this.view = view;
    }

    public BaseView(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    public T getView() {
        if (view != null) {
            return view;
        }
        view = (T) LayoutInflater.from(context).inflate(layoutId, null);
        return view;
    }

    // -------------------------- 加载View By ID. ------------------------------------
    public TextView getTextView(int id) {
        return (TextView) getView().findViewById(id);
    }

    public EditText getEditText(int id) {
        return (EditText) getView().findViewById(id);
    }

    public ImageView getImageView(int id) {
        return (ImageView) getView().findViewById(id);
    }

    public LinearLayout getLinearLayout(int id) {
        return (LinearLayout) getView().findViewById(id);
    }

    public RelativeLayout getRelativeLayout(int id) {
        return (RelativeLayout) getView().findViewById(id);
    }

    public View getView(int id) {
        return getView().findViewById(id);
    }

    // ------------------------------ 视图显示状态的控制 Start -----------------------------
    public enum STATE {
        LOADING, NO_NETWORK, ERROR, LOADED
    }

    private STATE viewState = STATE.LOADED;

    public void setViewState(STATE state) {
        this.viewState = state;
        switch (state) {
            case LOADING:
                setViewState(STATE.LOADING, R.layout.state_loading);
                break;
            case NO_NETWORK:
                setViewState(STATE.NO_NETWORK, R.layout.state_no_network);
                break;
            case ERROR:
                setViewState(STATE.ERROR, R.layout.state_error);
                break;
            case LOADED:
                setLoaded();
                break;
        }
    }

    public void setViewState(STATE state, int layoutId) {
        this.viewState = state;
        switch (state) {
            case LOADING:
            case NO_NETWORK:
            case ERROR:
                setDidNotLoad(layoutId);
                break;
            case LOADED:
                setLoaded();
                break;
            default:
                break;
        }
    }

    private static final int STATE_TAG = 0X9009;

    private void setDidNotLoad(int layoutId) {
        if (view != null && view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            if (vg.getChildCount() == 0) {
                addStateView(vg, layoutId);
            } else if (vg.getChildCount() == 1) {
                View child = vg.getChildAt(0);
                int tag = (Integer)(child.getTag());
                if (tag == STATE_TAG) {
                    vg.removeView(child);
                    addStateView(vg, layoutId);
                } else {
                    child.setVisibility(View.GONE);
                    addStateView(vg, layoutId);
                }
            } else {
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    child.setVisibility(View.GONE);
                }
                addStateView(vg, layoutId);
            }
        }
    }

    private void setLoaded() {
        if (view != null && view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            View stateView = null;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                Object tag = child.getTag();
                if (tag != null) {
                    if ((Integer)tag != STATE_TAG) {
                        child.setVisibility(View.VISIBLE);
                    } else {
                        stateView = child;
                    }
                } else {
                    child.setVisibility(View.VISIBLE);
                }
            }
            if (stateView != null) {
                vg.removeView(stateView);
            }
        }
    }

    private void addStateView(ViewGroup root, int layoutId) {
        View stateView = View.inflate(view.getContext(), layoutId, null);
        stateView.setTag(STATE_TAG);
        root.addView(stateView);
    }
    // ------------------------------ 视图显示状态的控制 End -----------------------------

}
