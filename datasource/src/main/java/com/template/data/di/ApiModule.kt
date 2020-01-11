package com.template.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.template.data.api.GithubApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */
class ApiModule{
    companion object{
      val apiModule = module {

        fun provideUseApi(retrofit: Retrofit): GithubApi {
          return retrofit.create(GithubApi::class.java)
        }



        fun provideGson(): Gson {
          return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
        }

        fun provideHttpClient(): OkHttpClient {
          val okHttpClientBuilder = OkHttpClient.Builder()

          return okHttpClientBuilder.build()
        }

        fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
          return Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
        }

        single { provideGson() }
        single { provideHttpClient() }
        single { provideRetrofit(get(), get()) }
        single { provideUseApi(get()) }
      }
    }
}