package com.determent.outlet2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform