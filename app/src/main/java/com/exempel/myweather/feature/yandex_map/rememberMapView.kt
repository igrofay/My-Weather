package com.exempel.myweather.feature.yandex_map

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView

@Composable
internal fun rememberMapViewWithLifeCycle(): MapView {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }
    val lifeCycleObserver = rememberLifeCycleObserver(mapView)
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifeCycle) {
        lifeCycle.addObserver(lifeCycleObserver)
        onDispose {
            lifeCycle.removeObserver(lifeCycleObserver)
        }
    }
    return mapView
}

@Composable
private fun rememberLifeCycleObserver(mapView: MapView): LifecycleEventObserver = remember(mapView) {
    LifecycleEventObserver { source, event ->
        when(event) {
            Lifecycle.Event.ON_CREATE ->{
                MapKitFactory.initialize(source as Context)
            }
            Lifecycle.Event.ON_START -> {
                MapKitFactory.getInstance().onStart()
                mapView.onStart()
            }
            Lifecycle.Event.ON_STOP -> {
                MapKitFactory.getInstance().onStop()
                mapView.onStop()
            }
            else ->{}
        }
    }
}