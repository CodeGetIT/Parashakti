package com.laundromat.others

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.github.nukc.stateview.StateView
import com.parashakti.R
import com.wang.avi.AVLoadingIndicatorView

class MyStateview {
    private var context: Context?
    private var mListener: ProgressClickListener
    private var mStateView: StateView? = null

    constructor(activity: Activity, view: View?, emptyView: Int, retryView: Int, loadingView: Int) {
        context = activity
        mListener = activity as ProgressClickListener
        mStateView = if (view == null) {
            StateView.inject(activity)
        } else {
            StateView.inject(view)
        }
        mStateView!!.setRetryResource(retryView)
        mStateView!!.setEmptyResource(emptyView)
        mStateView!!.setLoadingResource(loadingView)
        mStateView!!.setOnRetryClickListener(object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mListener.onRetryClick()
            }
        })
    }

    constructor(activity: Activity, view: View?) {
        context = activity
        mListener = activity as ProgressClickListener
        mStateView = if (view == null) {
            StateView.inject(activity)
        } else {
            StateView.inject(view)
        }
        mStateView!!.setRetryResource(R.layout.view_retry)
        mStateView!!.setEmptyResource(R.layout.view_empty)
        mStateView!!.setLoadingResource(R.layout.loading)
        mStateView!!.setOnRetryClickListener(object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mListener.onRetryClick()
            }
        })
    }

    constructor(fragment: Fragment, view: View?) {
        context = fragment.activity
        mListener = fragment as ProgressClickListener
        if (view == null) {
            mStateView = StateView.inject(fragment.requireView())
            mStateView!!.animate()
        } else {
            mStateView = StateView.inject(view)
        }
        val img = AVLoadingIndicatorView(context)
        mStateView!!.setRetryResource(R.layout.view_retry)
        mStateView!!.setEmptyResource(R.layout.view_empty)
        mStateView!!.setLoadingResource(R.layout.loading)


        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //shimmer_view_container = inflater.inflate(R.layout.loading, (ViewGroup) mStateView!!.getParent(), false).findViewById(R.id.shimmer_view_container);
        //   Animation animation = AnimationUtils.loadAnimation(context, R.anim.sequential);
        // iv_loading.setAnimation(animation);
        mStateView!!.setOnRetryClickListener(object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mListener.onRetryClick()
            }
        })
    }

    constructor(fragment: Fragment, view: View?, progressClickListener: ProgressClickListener) {
        context = fragment.activity
        mListener = progressClickListener
        mStateView = if (view == null) {
            StateView.inject(fragment.requireView())
        } else {
            StateView.inject(view)
        }
        mStateView!!.setRetryResource(R.layout.view_retry)
        mStateView!!.setEmptyResource(R.layout.view_empty)
        mStateView!!.setLoadingResource(R.layout.loading)
        mStateView!!.setOnRetryClickListener(object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mListener.onRetryClick()
            }
        })
    }

    constructor(activity: Activity?, view: View?, progressClickListener: ProgressClickListener) {
        context = activity
        mListener = progressClickListener
        mStateView = if (view == null) {
            StateView.inject(activity!!)
        } else {
            StateView.inject(view)
        }
        mStateView!!.setRetryResource(R.layout.view_retry)
        mStateView!!.setEmptyResource(R.layout.view_empty)
        mStateView!!.setLoadingResource(R.layout.loading)
        mStateView!!.setOnRetryClickListener(object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mListener.onRetryClick()
            }
        })
    }

    fun showLoading() {
        mStateView!!.showLoading()
    }

    fun showRetry() {
        mStateView!!.showRetry()
    }

    fun showContent() {
        mStateView!!.showContent()
    }

    fun showEmpty() {
        mStateView!!.showEmpty()
    }

    fun setEmptyResource(emptyResource: Int) {
        mStateView!!.setEmptyResource(emptyResource)
    }

    fun setLoadingResource(emptyResource: Int) {
        mStateView!!.setLoadingResource(emptyResource)
    }

    fun setRetryResource(emptyResource: Int) {
        mStateView!!.setRetryResource(emptyResource)
    }
}