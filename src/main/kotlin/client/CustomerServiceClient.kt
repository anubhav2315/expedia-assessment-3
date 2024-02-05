package org.example.client

import com.example.grpc.RequestData
import com.example.services.CustomerServiceGrpcKt
import com.example.services.RequestMessage
import com.example.services.ResponseMessage
import com.sun.xml.internal.ws.Closeable
import io.grpc.ManagedChannel
import java.util.concurrent.TimeUnit

class CustomerServiceClient(private val channel: ManagedChannel) : Closeable {

    private val stub: CustomerServiceGrpcKt.CustomerServiceCoroutineStub = CustomerServiceGrpcKt.CustomerServiceCoroutineStub(channel)

    suspend fun addition(firstNum : Int , secondNum : Int) : Int{

        val result : ResponseMessage = stub.addition(RequestMessage.newBuilder().setFirstNum(firstNum).setSecondNum(secondNum).build())
        return result.result
    }


    suspend fun subtraction(firstNum : Int , secondNum : Int) : Int {
        val result : ResponseMessage = stub.subtraction(RequestMessage.newBuilder().setFirstNum(firstNum).setSecondNum(secondNum).build())
        return result.result
    }

    suspend fun multiplication(firstNum: Int , secondNum: Int) : Int {
        val result: ResponseMessage = stub.multiplication(RequestMessage.newBuilder().setFirstNum(firstNum).setSecondNum(secondNum).build())
        return result.result

    }

    suspend fun division(firstNum: Int , secondNum: Int) : Int {
        val result: ResponseMessage = stub.division(RequestMessage.newBuilder().setFirstNum(firstNum).setSecondNum(secondNum).build())
        return result.result

    }
    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

}