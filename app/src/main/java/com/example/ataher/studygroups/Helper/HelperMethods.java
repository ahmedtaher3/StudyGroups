package com.example.ataher.studygroups.Helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;

/**
 * Created by a.taher on 7/4/2016.
 */
public class HelperMethods {

    public static String for_sale_townimage;
    public static String for_sale_troopsimage;
    public static String for_sale_name;
    public static String for_sale_mail;
    public static String for_sale_mobile;
    public static String for_sale_town_hall_level;
    public static String for_sale_name_change;
    public static String for_sale_android_ios;
    public static String for_sale_price;
    public static String for_sale_view_screens;
    public static String description;
    public static String for_sale_village_level;
    public static String for_sale_address;
    public static String for_sale_date;
    public static String for_sale_title;
    public static String Image_link_view;
    public static String plans_Image_link;
    public static String maps_image_link;
    public static String maps_image_link_type;
    public static String User_id;
    public static Uri uri_usre_profile_image;
    public static Uri uri_add_new_post;
    public static Uri uri_Post_usre_profile_image;
    public static Uri uri_add_for_sale_town_image;
    public static Uri uri_add_for_sale_trophy;
    public static String browser;
    public static String User_profile_id;
    public static String Comment_Post_id;
    public static String Post_id;
    public static String post_delete_my_post;
    public static String download_image_name;
    public static String Comments_on_post;
    public static String war_result_item;
    public static Uri uri_Chat_image;



    private static ProgressDialog blg;

    public static void showDialog(Activity currentActivity, String title, String msg) {
        blg = new ProgressDialog(currentActivity);
        blg.setTitle(title);
        blg.setCanceledOnTouchOutside(false);
        blg.setMessage(msg);
        blg.show();
    }

    public static void hideDialog(Activity currentActivity) {
        blg.cancel();
    }

}
