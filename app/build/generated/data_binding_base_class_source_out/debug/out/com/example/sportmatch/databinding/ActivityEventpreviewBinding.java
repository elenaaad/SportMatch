// Generated by view binder compiler. Do not edit!
package com.example.sportmatch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sportmatch.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEventpreviewBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavigationView;

  @NonNull
  public final Button previewBtnAddEv;

  @NonNull
  public final Button previewBtnEdit;

  @NonNull
  public final Button previewBtnMap;

  @NonNull
  public final TextView previewDate;

  @NonNull
  public final TextView previewDateInput;

  @NonNull
  public final TextView previewDesc;

  @NonNull
  public final TextView previewDescInput;

  @NonNull
  public final TextView previewLoc;

  @NonNull
  public final TextView previewLocInput;

  @NonNull
  public final TextView previewPlayers;

  @NonNull
  public final TextView previewPlayersInput;

  @NonNull
  public final TextView previewSport;

  @NonNull
  public final TextView previewSportInput;

  @NonNull
  public final TextView previewTime;

  @NonNull
  public final TextView previewTimeInput;

  @NonNull
  public final TextView previewTitle;

  @NonNull
  public final ImageView sportImage;

  @NonNull
  public final TextView title;

  private ActivityEventpreviewBinding(@NonNull RelativeLayout rootView,
      @NonNull BottomNavigationView bottomNavigationView, @NonNull Button previewBtnAddEv,
      @NonNull Button previewBtnEdit, @NonNull Button previewBtnMap, @NonNull TextView previewDate,
      @NonNull TextView previewDateInput, @NonNull TextView previewDesc,
      @NonNull TextView previewDescInput, @NonNull TextView previewLoc,
      @NonNull TextView previewLocInput, @NonNull TextView previewPlayers,
      @NonNull TextView previewPlayersInput, @NonNull TextView previewSport,
      @NonNull TextView previewSportInput, @NonNull TextView previewTime,
      @NonNull TextView previewTimeInput, @NonNull TextView previewTitle,
      @NonNull ImageView sportImage, @NonNull TextView title) {
    this.rootView = rootView;
    this.bottomNavigationView = bottomNavigationView;
    this.previewBtnAddEv = previewBtnAddEv;
    this.previewBtnEdit = previewBtnEdit;
    this.previewBtnMap = previewBtnMap;
    this.previewDate = previewDate;
    this.previewDateInput = previewDateInput;
    this.previewDesc = previewDesc;
    this.previewDescInput = previewDescInput;
    this.previewLoc = previewLoc;
    this.previewLocInput = previewLocInput;
    this.previewPlayers = previewPlayers;
    this.previewPlayersInput = previewPlayersInput;
    this.previewSport = previewSport;
    this.previewSportInput = previewSportInput;
    this.previewTime = previewTime;
    this.previewTimeInput = previewTimeInput;
    this.previewTitle = previewTitle;
    this.sportImage = sportImage;
    this.title = title;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEventpreviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEventpreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_eventpreview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEventpreviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomNavigationView;
      BottomNavigationView bottomNavigationView = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigationView == null) {
        break missingId;
      }

      id = R.id.previewBtnAddEv;
      Button previewBtnAddEv = ViewBindings.findChildViewById(rootView, id);
      if (previewBtnAddEv == null) {
        break missingId;
      }

      id = R.id.previewBtnEdit;
      Button previewBtnEdit = ViewBindings.findChildViewById(rootView, id);
      if (previewBtnEdit == null) {
        break missingId;
      }

      id = R.id.previewBtnMap;
      Button previewBtnMap = ViewBindings.findChildViewById(rootView, id);
      if (previewBtnMap == null) {
        break missingId;
      }

      id = R.id.previewDate;
      TextView previewDate = ViewBindings.findChildViewById(rootView, id);
      if (previewDate == null) {
        break missingId;
      }

      id = R.id.previewDateInput;
      TextView previewDateInput = ViewBindings.findChildViewById(rootView, id);
      if (previewDateInput == null) {
        break missingId;
      }

      id = R.id.previewDesc;
      TextView previewDesc = ViewBindings.findChildViewById(rootView, id);
      if (previewDesc == null) {
        break missingId;
      }

      id = R.id.previewDescInput;
      TextView previewDescInput = ViewBindings.findChildViewById(rootView, id);
      if (previewDescInput == null) {
        break missingId;
      }

      id = R.id.previewLoc;
      TextView previewLoc = ViewBindings.findChildViewById(rootView, id);
      if (previewLoc == null) {
        break missingId;
      }

      id = R.id.previewLocInput;
      TextView previewLocInput = ViewBindings.findChildViewById(rootView, id);
      if (previewLocInput == null) {
        break missingId;
      }

      id = R.id.previewPlayers;
      TextView previewPlayers = ViewBindings.findChildViewById(rootView, id);
      if (previewPlayers == null) {
        break missingId;
      }

      id = R.id.previewPlayersInput;
      TextView previewPlayersInput = ViewBindings.findChildViewById(rootView, id);
      if (previewPlayersInput == null) {
        break missingId;
      }

      id = R.id.previewSport;
      TextView previewSport = ViewBindings.findChildViewById(rootView, id);
      if (previewSport == null) {
        break missingId;
      }

      id = R.id.previewSportInput;
      TextView previewSportInput = ViewBindings.findChildViewById(rootView, id);
      if (previewSportInput == null) {
        break missingId;
      }

      id = R.id.previewTime;
      TextView previewTime = ViewBindings.findChildViewById(rootView, id);
      if (previewTime == null) {
        break missingId;
      }

      id = R.id.previewTimeInput;
      TextView previewTimeInput = ViewBindings.findChildViewById(rootView, id);
      if (previewTimeInput == null) {
        break missingId;
      }

      id = R.id.previewTitle;
      TextView previewTitle = ViewBindings.findChildViewById(rootView, id);
      if (previewTitle == null) {
        break missingId;
      }

      id = R.id.sportImage;
      ImageView sportImage = ViewBindings.findChildViewById(rootView, id);
      if (sportImage == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new ActivityEventpreviewBinding((RelativeLayout) rootView, bottomNavigationView,
          previewBtnAddEv, previewBtnEdit, previewBtnMap, previewDate, previewDateInput,
          previewDesc, previewDescInput, previewLoc, previewLocInput, previewPlayers,
          previewPlayersInput, previewSport, previewSportInput, previewTime, previewTimeInput,
          previewTitle, sportImage, title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
