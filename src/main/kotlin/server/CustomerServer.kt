import io.grpc.ServerBuilder
import org.example.service.CustomerServiceImpl
import java.util.concurrent.TimeUnit

fun main() {

    customerServer()
}


fun customerServer() {
    println("Starting the server")
    val customerServiceImpl : CustomerServiceImpl = CustomerServiceImpl()
    val server = ServerBuilder.forPort(50051).addService(customerServiceImpl).build()
    Runtime.getRuntime().addShutdownHook(Thread{
        server.shutdown().awaitTermination(5 , TimeUnit.SECONDS)
    })

    server.start()
    server.awaitTermination()
    println("Started the server")
}