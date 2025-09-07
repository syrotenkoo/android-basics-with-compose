package com.example.businesscard

import android.accessibilityservice.GestureDescription
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScrollModifierNode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.light_green_background)
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }

    @Composable
    fun BusinessCardScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            UserCard(
                R.drawable.user_icon,
                stringResource(R.string.full_name),
                stringResource(R.string.title)
            )
            Spacer(modifier = Modifier.height(60.dp))
            ContactsInfo(
                stringResource(R.string.phone_number),
                stringResource(R.string.social_media_handle),
                stringResource(R.string.email)
            )
        }
    }

    @Composable
    fun UserCard(
        @DrawableRes imageResourceId: Int,
        fullName: String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = fullName,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.dark_green),
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun ContactsInfo(
        phoneNumber: String,
        socialMediaHandle: String,
        email: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactsInfoRow(
                Icons.Filled.Call,
                stringResource(R.string.phone_number_description),
                phoneNumber
            )
            ContactsInfoRow(
                Icons.Filled.Share,
                stringResource(R.string.social_media_description),
                socialMediaHandle
            )
            ContactsInfoRow(
                Icons.Filled.Email,
                stringResource(R.string.email_description),
                email
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    @Composable
    fun ContactsInfoRow(
        contactIcon: ImageVector,
        contactIconDescription: String,
        contactsInfoString: String,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                contactIcon,
                contentDescription = contactIconDescription,
                tint = colorResource(id = R.color.dark_green),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = contactsInfoString,
                fontSize = 16.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BusinessCardTheme {
            BusinessCardScreen()
        }
    }
}