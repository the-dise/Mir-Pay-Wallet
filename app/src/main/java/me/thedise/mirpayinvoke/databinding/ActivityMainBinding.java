package me.thedise.mirpayinvoke.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.wear.widget.BoxInsetLayout;

import me.thedise.mirpayinvoke.R;

public final class ActivityMainBinding implements ViewBinding {
    public final ImageView icon;
    public final FrameLayout mainContainer;
    public final TextView countdown;
    private final BoxInsetLayout rootView;

    private ActivityMainBinding(BoxInsetLayout rootView, ImageView icon,
                                FrameLayout mainContainer, TextView countdown) {
        this.rootView = rootView;
        this.icon = icon;
        this.mainContainer = mainContainer;
        this.countdown = countdown;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainBinding bind(View rootView) {
        int[] viewIds = {R.id.icon, R.id.mainContainer, R.id.countdown};
        View[] views = new View[viewIds.length];

        for (int i = 0; i < viewIds.length; i++) {
            views[i] = ViewBindings.findChildViewById(rootView, viewIds[i]);
            if (views[i] == null) {
                String missingId = rootView.getResources().getResourceName(viewIds[i]);
                throw new NullPointerException("Missing required view with ID: " + missingId);
            }
        }

        return new ActivityMainBinding((BoxInsetLayout) rootView, (ImageView) views[0],
                (FrameLayout) views[1], (TextView) views[2]);
    }


    @NonNull
    @Override
    public BoxInsetLayout getRoot() {
        return this.rootView;
    }
}