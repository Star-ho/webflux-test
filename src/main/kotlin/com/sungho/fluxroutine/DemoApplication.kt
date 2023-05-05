package com.sungho.fluxroutine

import kotlinx.coroutines.debug.CoroutinesBlockHoundIntegration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.blockhound.BlockHound
import reactor.blockhound.integration.ReactorIntegration
import reactor.blockhound.integration.RxJava2Integration
import reactor.blockhound.integration.StandardOutputIntegration


@SpringBootApplication
class FluxRoutineApplication

fun main(args: Array<String>) {
    runApplication<FluxRoutineApplication>(*args)
    BlockHound
        .builder()
        .with(CoroutinesBlockHoundIntegration())
        .with(StandardOutputIntegration())
        .with(ReactorIntegration())
        .with(RxJava2Integration())
        .install()
}
