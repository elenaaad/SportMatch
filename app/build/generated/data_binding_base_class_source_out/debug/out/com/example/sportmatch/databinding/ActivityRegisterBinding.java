// Generated by view binder compiler. Do not edit!
package com.example.sportmatch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sportmatch.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextInputLayout BirthDate;

  @NonNull
  public final TextInputEditText BirthDateInserted;

  @NonNull
  public final TextInputLayout ConfirmPassword;

  @NonNull
  public final TextInputLayout FullName;

  @NonNull
  public final TextInputEditText FullNameInserted;

  @NonNull
  public final TextInputLayout Password;

  @NonNull
  public final TextInputEditText PasswordConfirmed;

  @NonNull
  public final TextInputEditText PasswordInserted;

  @NonNull
  public final TextView Register;

  @NonNull
  public final TextInputLayout Username;

  @NonNull
  public final TextInputEditText UsernameInserted;

  @NonNull
  public final Button signupButton;

  private ActivityRegisterBinding(@NonNull RelativeLayout rootView,
      @NonNull TextInputLayout BirthDate, @NonNull TextInputEditText BirthDateInserted,
      @NonNull TextInputLayout ConfirmPassword, @NonNull TextInputLayout FullName,
      @NonNull TextInputEditText FullNameInserted, @NonNull TextInputLayout Password,
      @NonNull TextInputEditText PasswordConfirmed, @NonNull TextInputEditText PasswordInserted,
      @NonNull TextView Register, @NonNull TextInputLayout Username,
      @NonNull TextInputEditText UsernameInserted, @NonNull Button signupButton) {
    this.rootView = rootView;
    this.BirthDate = BirthDate;
    this.BirthDateInserted = BirthDateInserted;
    this.ConfirmPassword = ConfirmPassword;
    this.FullName = FullName;
    this.FullNameInserted = FullNameInserted;
    this.Password = Password;
    this.PasswordConfirmed = PasswordConfirmed;
    this.PasswordInserted = PasswordInserted;
    this.Register = Register;
    this.Username = Username;
    this.UsernameInserted = UsernameInserted;
    this.signupButton = signupButton;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.BirthDate;
      TextInputLayout BirthDate = ViewBindings.findChildViewById(rootView, id);
      if (BirthDate == null) {
        break missingId;
      }

      id = R.id.BirthDateInserted;
      TextInputEditText BirthDateInserted = ViewBindings.findChildViewById(rootView, id);
      if (BirthDateInserted == null) {
        break missingId;
      }

      id = R.id.ConfirmPassword;
      TextInputLayout ConfirmPassword = ViewBindings.findChildViewById(rootView, id);
      if (ConfirmPassword == null) {
        break missingId;
      }

      id = R.id.FullName;
      TextInputLayout FullName = ViewBindings.findChildViewById(rootView, id);
      if (FullName == null) {
        break missingId;
      }

      id = R.id.FullNameInserted;
      TextInputEditText FullNameInserted = ViewBindings.findChildViewById(rootView, id);
      if (FullNameInserted == null) {
        break missingId;
      }

      id = R.id.Password;
      TextInputLayout Password = ViewBindings.findChildViewById(rootView, id);
      if (Password == null) {
        break missingId;
      }

      id = R.id.PasswordConfirmed;
      TextInputEditText PasswordConfirmed = ViewBindings.findChildViewById(rootView, id);
      if (PasswordConfirmed == null) {
        break missingId;
      }

      id = R.id.PasswordInserted;
      TextInputEditText PasswordInserted = ViewBindings.findChildViewById(rootView, id);
      if (PasswordInserted == null) {
        break missingId;
      }

      id = R.id.Register;
      TextView Register = ViewBindings.findChildViewById(rootView, id);
      if (Register == null) {
        break missingId;
      }

      id = R.id.Username;
      TextInputLayout Username = ViewBindings.findChildViewById(rootView, id);
      if (Username == null) {
        break missingId;
      }

      id = R.id.UsernameInserted;
      TextInputEditText UsernameInserted = ViewBindings.findChildViewById(rootView, id);
      if (UsernameInserted == null) {
        break missingId;
      }

      id = R.id.signupButton;
      Button signupButton = ViewBindings.findChildViewById(rootView, id);
      if (signupButton == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((RelativeLayout) rootView, BirthDate, BirthDateInserted,
          ConfirmPassword, FullName, FullNameInserted, Password, PasswordConfirmed,
          PasswordInserted, Register, Username, UsernameInserted, signupButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
