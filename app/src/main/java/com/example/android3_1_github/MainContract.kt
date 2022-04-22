package com.example.android3_1_github

class MainContract {
    interface ViewModel {
        val shouldShowProgress: Boolean
        val isSuccess: Boolean
        val setError: String
    }
}