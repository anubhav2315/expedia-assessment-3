import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.example.client.CustomerServiceClient

suspend fun main() {

    val port = System.getenv("PORT")?.toInt() ?: 50051

    val channel : ManagedChannel = ManagedChannelBuilder.
                                    forAddress("localhost" , port).
                                    usePlaintext().build()

    val client : CustomerServiceClient = CustomerServiceClient(channel)
    // Performing the addition
    println(client.addition(12, 10))
    println("Addition completed")

    // Performing subtract operation
    client.subtraction(13,10)

    //Performing multiplication operation
    client.multiplication(5,7)

    //Performing division operation
    client.division(15 ,5)
}