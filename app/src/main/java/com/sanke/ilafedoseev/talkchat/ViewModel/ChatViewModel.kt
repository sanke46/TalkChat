package com.sanke.ilafedoseev.talkchat.ViewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.sanke.ilafedoseev.talkchat.Model.Message
import com.sanke.ilafedoseev.talkchat.R

/**
 * Created by ilafedoseev on 10/11/2017.
 */

class ChatViewModel(private val _id:Int,
                    private var _messages:List<Message>,
                    private val _nameOne:String,
                    private val _nameTwo:String) : BaseObservable() {

    val id: Int
        get() = _id

    var messages: List<Message>
        @Bindable
        get() = _messages
        set(value) {
            _messages = value
            notifyPropertyChanged(R.id.listMessage)
        }

    val nameOne: String
        get() = _nameOne

    val nameTwo: String
        get() = _nameTwo
}
