import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class Helper {
    public static Bitmap getBitMapFromAsset (Context context, String id)
    {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;

        try {
            inputStream = assetManager.open("id" + ".png");
            return BitmapFactory.decodeStream(inputStream);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
            return null;
        }
    }
    public static String getPriceFormatted (double price)
    {
        return NumberFormat.getCurrencyInstance().format(price);
    }
}
