/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toDrawable
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDogList()
        setContent {
            val navController = rememberNavController()
            val navHost = NavHost(navController = navController, startDestination = "dogList") {
                composable("dogList") {
                    LoadDogList(navController)
                }
                composable("dogDetail/{dogId}",arguments = listOf(navArgument("dog") {defaultValue = "dog"})) {navBackStackEntry->
                    LoadDogDetailScreen(navController, navBackStackEntry.arguments?.getString("dogId"))
                }
            }
        }
    }

    val listOfDogs = mutableListOf<Dog>()

    private fun createDogList() {
        listOfDogs.add(Dog("boxer"))
        listOfDogs.add(Dog("bulldog"))
        listOfDogs.add(Dog("deerhound"))
        listOfDogs.add(Dog("husky"))
        listOfDogs.add(Dog("labrador"))
        listOfDogs.add(Dog("mastiff"))
        listOfDogs.add(Dog("otterhound"))
        listOfDogs.add(Dog("papillon"))
        listOfDogs.add(Dog("pitbull"))
        listOfDogs.add(Dog("poodle"))
        listOfDogs.add(Dog("pug"))
        listOfDogs.add(Dog("retriever"))
        listOfDogs.add(Dog("saluki"))
        listOfDogs.add(Dog("setter"))
    }

    @Composable
    private fun LoadDogList(navController: NavController) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(listOfDogs) {dog ->
                Text(
                    dog.breed,
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth()
                        .background(Color.Green)
                        .clickable {
                            navController.navigate("dogDetail/${dog.id}") {
//                                popUpTo("dogList") {inclusive = true}
                            }

                        }
                )
            }
        }
    }

    @Composable
    private fun LoadDogDetailScreen( navController: NavController, dogId:String?) {
        Column (modifier = Modifier.padding(16.dp)){
            val dog = listOfDogs.filter { it.id == dogId }.get(0)
            Text(dog.breed)
            Text(dog.details)
        }
    }


//    @Composable
//    fun loadPicture(url: String): Bitmap {
//        var bitmap by remember { mutableStateOf<Drawable?>(null) }
//
//        Glide.with(LocalContext.current).asBitmap()
//            .load("https://picsum.photos/200/300")
//            .into(object : CustomTarget<Bitmap>() {
//                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                    bitmap = resource
//                }
//
//                override fun onLoadCleared(placeholder: Drawable?) {}
//            })
//        return bitmap
//    }

//    @Composable
//    private fun NewStory() {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Image(
//                painterResource(id = R.drawable.ic_baseline_directions_run_24),
//                contentDescription = null,
//                modifier = Modifier
//                    .height(180.dp)
//                    .clip(shape = RoundedCornerShape(16.dp))
//                    .fillMaxWidth(),
//                colorFilter = ColorFilter.tint(Color.Blue, BlendMode.SrcIn)
//            )
//            Spacer(Modifier.height(16.dp))
//            Text("This is shailesh kumar", maxLines = 2, overflow = TextOverflow.Ellipsis)
//            Text("He has to learn a lot")
//            Text("He should try harder")
//        }
//    }
//
//    @Preview
//    @Composable
//    private fun PreviewNewStory() {
//        NewStory()
//    }
//
//    @Composable
//    fun Greeting(name: String) {
//        Text("Hello $name")
//    }

//    @Preview
//    @Composable
//    fun PreviewGreeting() {
//        Greeting(name = "shailesh")
//    }
}

// Start building your app here!
//@Composable
//fun MyApp() {
//    Surface(color = MaterialTheme.colors.background) {
//        Text(text = "Ready... Set... GO!")
//    }
//}
//
//@Preview("Light Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun LightPreview() {
//    MyTheme {
//        MyApp()
//    }
//}
//
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}
