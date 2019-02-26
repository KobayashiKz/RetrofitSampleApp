package com.kk.retrofitsampleapp.retrofitsampleapp

import android.telecom.Call
import okhttp3.RequestBody
import retrofit2.http.*

// 1. アノテーションを使用したインターフェース作成
interface ApiService {

    // アノテーションはGET/POST/PUT/DELETE/HEADの5つ

    // 規定URL以降を定義する
    // @GET("user/list?sort=desc") のようにクエリパラメータも指定可能
    @GET("api")
    fun apiDemo(): Call<RandomUserDemo>

    // @Path
    // @GETに可変の要素が含まれる場合に@Pathを使用する
    // @GETの{}内と@Pathの()を同一にする
    @GET("group/{id}/users")
    fun groupList(@Path("id") groupId: Int): Call<List<User>>

    // @Query
    // ?以降のクエリ部分は@Queryで指定する
    // https://randomuser.me/group/3/users?sort=desc
    // 上記のようにidが@Pathで入り、?以降が@Queryにより入る
    @GET("group/{id}/users")
    fun groupList(@Path("id") groupId: Int, @Query("sort") sort: String): Call<List<User>>

    // key,value変換してAPIで送りたい場合インスタンスクラスを引数にするインターフェース用意して@Bodyをつける
    @POST("users/new")
    fun createUser(@Body user: User): Call<User>

    // 変数をkey,value変換して送りたい場合@FormUrlEncodedをつけて@Fieldをつける
    @FormUrlEncoded
    @POST("user/edit")
    fun updateUser(@Field("first name") first: String, @Field("last_name") last: String): Call<User>

    // Multipartでデータを送りたい場合は@Partまたは@PartMapをつける
    @Multipart
    @PUT("user/photo")
    fun updateUser(@Part("photo") photo: RequestBody, @Part("description") description: RequestBody): Call<User>

    // ヘッダの単体指定
    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    fun widgetList(): Call<List<Widget>>

//    // ヘッダの複数指定
//    @Headers(
//        "Accept: application/vnd.github.v3.full+json",
//        "User-Agent: Retrofit-Sample-App")
//    @GET("users/{username}")
//    fun getUser(@Path("username") username: String): Call<User>
//
//    // ヘッダの動的指定
//    @GET("user")
//    fun getUser(@Header("Authorization") authorization: String): Call<User>
}