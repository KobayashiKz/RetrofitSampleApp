package com.kk.retrofitsampleapp.retrofitsampleapp

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName


data class RandomUserDemo(var info: IDNA.Info,
                          var results: List<Result>) {


}

data class Info(var seed: String,
                var results: Int,
                var page: Int,
                var version: String)

data class Result(var gender: String,
                  var email: String,
                  var registered: String,
                  var dob: String,
                  var phone: String,
                  var cell: String,
                  // @SerializedNameでkey名と変数名を別々にできる
                  @SerializedName("id") var iMap: IdMap)

// @Transient: 逆にkeyとvalueに変換したくない場合に使用する
data class IdMap(@Transient var id: Long,
                 var name: String,
                 var value: String)

data class User(var name: String)
