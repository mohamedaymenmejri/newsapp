package com.aymen.instantnews.common.archi.activity.provider

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import javax.inject.Provider

/**
 * @author Mohamed Aymen Mejri on 20/02/2019.
 * @since 0.0.1
 *
 * This class is made to centralize lifecycle owner's life cycle.
 */
class LifecycleRegistryProvider(var owner: LifecycleOwner) :
    Provider<LifecycleRegistry> {
    override fun get(): LifecycleRegistry = LifecycleRegistry(owner)
}
