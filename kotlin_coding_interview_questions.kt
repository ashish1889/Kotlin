
// 1. Check if a string is a palindrome (without using reversed)
fun isPalindrome(str: String): Boolean {
    val len = str.length
    for (i in 0 until len / 2) {
        if (str[i] != str[len - 1 - i]) return false
    }
    return true
}

// 2. Reverse each word in a sentence
fun reverseEachWord(sentence: String): String {
    val words = mutableListOf<String>()
    var word = ""
    for (char in sentence) {
        if (char != ' ') {
            word += char
        } else {
            words.add(reverse(word))
            word = ""
        }
    }
    if (word.isNotEmpty()) words.add(reverse(word))
    return words.joinToString(" ")
}

fun reverse(input: String): String {
    var result = ""
    for (i in input.length - 1 downTo 0) {
        result += input[i]
    }
    return result
}

// 3. Count vowels and consonants
fun countVowelsAndConsonants(str: String): Pair<Int, Int> {
    val vowels = "aeiouAEIOU"
    var vowelCount = 0
    var consonantCount = 0
    for (c in str) {
        if (c.isLetter()) {
            if (vowels.contains(c)) vowelCount++ else consonantCount++
        }
    }
    return Pair(vowelCount, consonantCount)
}

// 4. First non-repeating character
    fun firstNonRepeatingChar(str: String): Char? {
    val count = IntArray(256)
    for (c in str) count[c.code]++
    for (c in str) if (count[c.code] == 1) return c
    return null
}

// 5. Check if two strings are anagrams
fun areAnagrams(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false
    val count = IntArray(256)
    for (i in s1.indices) {
        count[s1[i].code]++
        count[s2[i].code]--
    }
    return count.all { it == 0 }
}

// 6. Remove duplicate characters from a string
fun removeDuplicates(str: String): String {
    val seen = BooleanArray(256)
    var result = ""
    for (c in str) {
        if (!seen[c.code]) {
            seen[c.code] = true
            result += c
        }
    }
    return result
}

// 7. Compress a string (e.g., a3b2c4)o
fun compressString(str: String): String {
    if (str.isEmpty()) return ""
    var result = ""
    var count = 1
    for (i in 1 until str.length) {
        if (str[i] == str[i - 1]) count++
        else {
            result += str[i - 1] + count.toString()
            count = 1
        }
    }
    result += str.last() + count.toString()
    return result
}

// 8. Count number of digits in a number
fun countDigits(num: Int): Int {
    var n = num
    var count = 0
    if (n == 0) return 1
    while (n != 0) {
        count++
        n /= 10
    }
    return count
}

// 9. Reverse a number without converting to string
fun reverseNumber(num: Int): Int {
    var n = num
    var rev = 0
    while (n != 0) {
        rev = rev * 10 + (n % 10)
        n /= 10
    }
    return rev
}

// 10. Check if a number is palindrome
fun isNumberPalindrome(num: Int): Boolean {
    return num == reverseNumber(num)
}

// 11. Find GCD and LCM
fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val temp = y
        y = x % y   
        x = temp
    }
    return x
}

fun lcm(a: Int, b: Int): Int {
    return (a * b) / gcd(a, b)
}
