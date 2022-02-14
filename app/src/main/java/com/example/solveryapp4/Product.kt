package com.example.solveryapp4

import androidx.annotation.DrawableRes

data class Product(@DrawableRes val avatar: Int, val name: String, val producer: String, val cost: Int)
