package com.iyaliyul.newssssapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iyaliyul.newssssapp.data.model.ResponseNews
import com.iyaliyul.newssssapp.data.repository.NewsRepository
import com.iyaliyul.newssssapp.utils.Constant
import com.iyaliyul.newssssapp.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {
    private val _newsData = MutableLiveData<Resources<ResponseNews>>()
    val newsData = _newsData

    init {
        getNews()
    }

    private fun getNews() = viewModelScope.launch {
        _newsData.value = Resources.Loading
        repository.getNews(
            Constant.COUNTRY,
            Constant.API_KEY
        ).collect { news ->
            _newsData.value = news
        }
    }
}