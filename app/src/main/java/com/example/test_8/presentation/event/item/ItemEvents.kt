package com.example.test_8.presentation.event.item

sealed class ItemEvents {
data object GetItems : ItemEvents()
data object UpdateErrorMessages : ItemEvents()
}