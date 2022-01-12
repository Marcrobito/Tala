package dev.eighteentech.tala.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class NetworkService @Inject constructor(private val interceptor: MockRequestInterceptor) {

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    val service: Api = Retrofit.Builder()
        .baseUrl("http://fakeapp.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run {
            create(Api::class.java)
        }
}

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideApi(networkService: NetworkService): Api {
        return networkService.service
    }
}