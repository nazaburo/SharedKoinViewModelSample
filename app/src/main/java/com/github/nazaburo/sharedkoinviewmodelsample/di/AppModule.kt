package com.github.nazaburo.sharedkoinviewmodelsample.di

import com.github.nazaburo.sharedkoinviewmodelsample.viewmodel.SharedViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SharedViewModel)
}
