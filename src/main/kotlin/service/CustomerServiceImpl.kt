package org.example.service

import com.example.services.CustomerServiceGrpcKt
import com.example.services.RequestMessage
import com.example.services.ResponseMessage

class CustomerServiceImpl : CustomerServiceGrpcKt.CustomerServiceCoroutineImplBase() {

    override suspend fun addition(request: RequestMessage): ResponseMessage {
        return ResponseMessage.newBuilder()
            .setResult(request.firstNum + request.secondNum)
            .build()
    }

    override suspend fun division(request: RequestMessage): ResponseMessage {
        val result : Int ;
        if(request.secondNum != 0) {
            result = request.firstNum/request.secondNum
        }
        else {
            throw RuntimeException("Denominator cannot be zero")
        }
        return ResponseMessage.newBuilder()
                .setResult(result)
            .build()
    }


    override suspend fun multiplication(request: RequestMessage): ResponseMessage {
        return ResponseMessage.newBuilder()
            .setResult(request.firstNum*request.secondNum)
            .build()
    }

    override suspend fun subtraction(request: RequestMessage): ResponseMessage {
        return ResponseMessage.newBuilder()
            .setResult(request.firstNum - request.secondNum)
            .build()
    }
}