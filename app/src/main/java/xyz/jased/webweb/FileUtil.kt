package xyz.jased.webweb

import android.content.Context
import android.util.Log
import java.io.File
import java.io.IOException

class FileUtil {
    companion object {
        fun writeFile(fileName: String, data: String, applicationContext: Context): Boolean { // https://www.bezkoder.com/kotlin-write-file/
            Log.d(null, "DEBUG: creating ${applicationContext.filesDir}/$fileName - $data")

            try {
                File(applicationContext.filesDir, fileName).bufferedWriter().use { fileOut ->
                    fileOut.write(data)
                }

                return true
            } catch (e: IOException) {
                return false // fail
            }
        }

        fun deleteFile(fileName: String, applicationContext: Context): Boolean {
            Log.d(null, "DEBUG: deleting ${applicationContext.filesDir}/$fileName")

            try {
                File(applicationContext.filesDir, fileName).delete()
                return true
            } catch (e: IOException) {
                return false // fail
            }
        }

        fun readFile(fileName: String, applicationContext: Context): String? {
            Log.d(null, "DEBUG: ${applicationContext.filesDir}/$fileName - READ")

            try {
                File(applicationContext.filesDir, fileName).bufferedReader().use { fileOut ->
                    val fileData = fileOut.readText()
                    Log.d(null, "DEBUG: ${applicationContext.filesDir}/$fileName - GOT $fileData")
                    return fileData
                }
            } catch (e: IOException) {
                return null // fail
            }
        }
    }
}