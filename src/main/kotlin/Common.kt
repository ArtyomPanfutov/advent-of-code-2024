package org.example

fun getInput(path: String) = object {}.javaClass.getResource(path).readText()
