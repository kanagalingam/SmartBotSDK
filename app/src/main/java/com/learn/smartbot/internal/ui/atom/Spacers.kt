package com.learn.smartbot.internal.ui.atom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpace4() = Spacer(modifier = Modifier.height(4.dp))

@Composable
fun VerticalSpace8() = Spacer(modifier = Modifier.height(8.dp))

@Composable
fun VerticalSpace16() = Spacer(modifier = Modifier.height(16.dp))

@Composable
fun HorizontalSpace4() = Spacer(modifier = Modifier.width(4.dp))

@Composable
fun HorizontalSpace8() = Spacer(modifier = Modifier.width(8.dp))

@Composable
fun HorizontalSpace16() = Spacer(modifier = Modifier.width(16.dp))