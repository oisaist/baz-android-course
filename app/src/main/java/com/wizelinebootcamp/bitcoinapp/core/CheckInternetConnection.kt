@file:Suppress("BlockingMethodInNonBlockingContext")

package com.wizelinebootcamp.bitcoinapp.core

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import java.nio.channels.IllegalBlockingModeException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

object CheckInternetConnection {

    suspend fun isNetworkAvailable() = coroutineScope {
        return@coroutineScope try {
            withContext(Dispatchers.IO) {
                val sock = Socket()
                val socketAddress = InetSocketAddress("8.8.8.8", 53)
                sock.connect(socketAddress, 2000)
                sock.close()
                true
            }
        } catch (e: IOException) { false } catch (e: IllegalBlockingModeException) { false } catch (
            e: IllegalArgumentException
        ) { false }
    }
}
