package weathercheckter.johnnyzhao.com.weathercheckter.project

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V : BaseView> : LifecycleObserver {

    protected var currentView: V? = null;

    /**
     * Composite disposable for dispose all the disposable.
     * The concrete implementation of this class should add all the
     * disposables to this and BasePresenter will take care of clearing it up when exit the view.
     */
    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    protected val isViewAttached: Boolean get() = currentView != null

    fun attachView(view: V) {
        if (currentView != null)
            currentView = null
        currentView = view
    }

    fun detachView() {
        compositeDisposable.dispose()
        currentView = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanYourSelf() {
        detachView();
    }
}