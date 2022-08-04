package com.sbs.android.di

import com.sbs.data.BuildConfig
import com.sbs.data.movie.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    /* @Singleton
     @Provides
     fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
         return ChuckerInterceptor.Builder(context)
             .collector(ChuckerCollector(context))
             .maxContentLength(250000L)
             .redactHeaders(emptySet())
             .alwaysReadResponseBody(false)
             .build()
     }*/

    @Singleton
    @Provides
    fun provideOkHttpClient(
        logging: HttpLoggingInterceptor/*,
        chucker: ChuckerInterceptor*/
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)/*
            .addInterceptor(chucker)*/
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okhttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okhttp)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}