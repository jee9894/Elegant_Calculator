package com.example.new_sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var b1: Button? = null
    private var b2: Button? = null
    private var b3: Button? = null
    private var b4: Button? = null
    private var b5: Button? = null
    private var b6: Button? = null
    private var b7: Button? = null
    private var b8: Button? = null
    private var b9: Button? = null
    private var b0: Button? = null
    private var bEqual: Button? = null
    private var bMulti: Button? = null
    private var bDivide: Button? = null
    private var bAdd: Button? = null
    private var bSub: Button? = null
    private var bClear: Button? = null
    private var bDot: Button? = null
    private var bPercent: Button? = null
    private var bPlusMinus: Button? = null
    private var tInput: TextView? = null
    private var tOutput: TextView? = null
    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val EQUAL = '='
    private val EXTRA = '@'
    private val MODULUS = '%'
    private var ACTION = 0.toChar()
    private var val1: Double = Double.NaN
    private var val2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListener()
    }

    private fun setupView() {
        b1 = findViewById(R.id.button1)
        b2 = findViewById(R.id.button2)
        b3 = findViewById(R.id.button3)
        b4 = findViewById(R.id.button4)
        b5 = findViewById(R.id.button5)
        b6 = findViewById(R.id.button6)
        b7 = findViewById(R.id.button7)
        b8 = findViewById(R.id.button8)
        b9 = findViewById(R.id.button9)
        b0 = findViewById(R.id.button0)
        bEqual = findViewById(R.id.button_equal)
        bMulti = findViewById(R.id.button_multi)
        bDivide = findViewById(R.id.button_divide)
        bAdd = findViewById(R.id.button_add)
        bSub = findViewById(R.id.button_sub)
        bClear = findViewById(R.id.button_clear)
        bDot = findViewById(R.id.button_dot)
        bPercent = findViewById(R.id.button_para1)
        bPlusMinus = findViewById(R.id.button_para2)
        tInput = findViewById(R.id.input)
        tOutput = findViewById(R.id.output)
    }

    @SuppressLint("SetTextI18n")
    private fun setupListener() {
        b1?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "1"
        }
        b2?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "2"
        }
        b3?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "3"
        }
        b4?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "4"
        }
        b5?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "5"
        }
        b6?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "6"
        }
        b7?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "7"
        }
        b8?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "8"
        }
        b9?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "9"
        }
        b0?.setOnClickListener {
            errorCheck()
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "0"
        }
        bDot?.setOnClickListener {
            exceedOutputLength()
            tInput?.text = tInput?.text.toString() + "."
        }
        bPercent?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                ACTION = MODULUS
                operation()
                if (!isDecimal()) {
                    tOutput?.text = "$val1%"
                } else {
                    tOutput?.text = val1.toInt().toString() + "%"
                }
                tInput?.text = null
            } else {
                tOutput?.text = "Error"
            }
        }
        bAdd?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                ACTION = ADDITION
                operation()
                if (!isDecimal()) {
                    tOutput?.text = "$val1+"
                } else {
                    tOutput?.text = val1.toInt().toString() + "+"
                }
                tInput?.text = null
            } else {
                tOutput?.text = "Error"
            }
        }
        bSub?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                ACTION = SUBTRACTION
                operation()
                if (!isDecimal()) {
                    tOutput?.text = "$val1-"
                } else {
                    tOutput?.text = val1.toInt().toString() + "-"
                }
                tInput?.text = null
            } else {
                tOutput?.text = "Error"
            }
        }
        bMulti?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                ACTION = MULTIPLICATION
                operation()
                if (!isDecimal()) {
                    tOutput?.text = "${val1}x"
                } else {
                    tOutput?.text = val1.toInt().toString() + "x"
                }
                tInput?.text = null
            } else {
                tOutput?.text = "Error"
            }
        }
        bDivide?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                ACTION = DIVISION
                operation()
                if (!isDecimal()) {
                    tOutput?.text = "$val1/"
                } else {
                    tOutput?.text = val1.toInt().toString() + "/"
                }
                tInput?.text = null
            } else {
                tOutput?.text = "Error"
            }
        }
        bPlusMinus?.setOnClickListener {
            if (tOutput?.text.toString().isNotEmpty() || tInput?.text.toString().isNotEmpty()) {
                val1 = tInput?.text.toString().toDouble()
                ACTION = EXTRA
                tOutput?.text = "-" + tInput?.text.toString()
                tInput?.text = ""
            } else {
                tOutput?.text = "Error"
            }
        }
        bEqual?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                operation()
                ACTION = EQUAL
                if (!isDecimal()) {
                    tOutput?.text = val1.toString()
                } else {
                    tOutput?.text = val1.toInt().toString()
                }
                tInput?.text = null
            } else {
                tOutput?.text = "Error"
            }
        }
        bClear?.setOnClickListener {
            if (tInput?.text.toString().isNotEmpty()) {
                val name: CharSequence = tInput?.text.toString()
                tInput?.text = name.subSequence(0, name.length - 1)
            } else {
                val1 = Double.NaN
                val2 = Double.NaN
                tInput?.text = ""
                tOutput?.text = ""
            }
        }

        bClear?.setOnLongClickListener {
            val1 = Double.NaN
            val2 = Double.NaN
            tInput?.text = ""
            tOutput?.text = ""
            true
        }
    }

    private fun operation() {
        if (!val1.isNaN()) {
            if (tOutput?.text.toString()[0] == '-') {
                val1 *= -1
            }
            val2 = tInput?.text.toString().toDouble()
            when (ACTION) {
                ADDITION -> val1 += val2
                SUBTRACTION -> val1 -= val2
                MULTIPLICATION -> val1 *= val2
                DIVISION -> val1 /= val2
                EXTRA -> val1 *= -1
                MODULUS -> val1 %= val2
                // EQUAL -> { }
            }
        } else {
            val1 = tInput?.text.toString().toDouble()
        }
    }

    // Remove error message that is already written there.
    private fun errorCheck() {
        if (tOutput?.text.toString() == "Error") {
            tOutput?.text = ""
        }
    }

    // Whether value if a double or not
    private fun isDecimal(): Boolean {
        return val1 == val1.toInt().toDouble()
    }

    private fun noOperation() {
        var inputExpression = tOutput?.text.toString()
        if (!inputExpression.isEmpty() && inputExpression != "Error") {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "")
                tOutput?.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "")
                tOutput?.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "")
                tOutput?.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "")
                tOutput?.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "")
                tOutput?.text = ""
                val1 = inputExpression.toDouble()
            }
        }
    }

    // Make text small if too many digits.
    private fun exceedOutputLength() {
        if (tInput?.text.toString().length > 10) {
            tInput?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }
}