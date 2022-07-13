package dev.bakhita.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.bakhita.mycontacts.databinding.ContactsListItemsBinding

class ContactRecyclerViewAdapter(var contactsList: List<Contacts>):
    RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding=ContactsListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact= contactsList.get(position)
        val context=holder.itemView.context
        with(holder.binding){
            tvName.text=currentContact.name
            tvNumber.text=currentContact.number
            tvEmail.text=currentContact.email
            tvAddress.text=currentContact.address
            Picasso.get()
                .load(currentContact.Image)
                .resize(300, 300)
                .centerCrop()
                .into(imgContacts)

            cvContacts.setOnClickListener{
                val intent=Intent(context, viewContactActivity::class.java)
                intent.putExtra("NAME", currentContact.name)
                intent.putExtra("PHONE_NUMBER", currentContact.number)
                intent.putExtra("EMAIL", currentContact.email)
                intent.putExtra("ADDRESS", currentContact.address)
                intent.putExtra("IMAGE",currentContact.Image)
                context.startActivity(intent)
            }
            holder.binding.imgContacts.setOnClickListener {
                Toast
                    .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}
class ContactsViewHolder(var binding: ContactsListItemsBinding): RecyclerView.ViewHolder(binding.root) {
}