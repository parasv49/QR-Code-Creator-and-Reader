# QR-Code-Creator-and-Reader

This code help to scan OR code and create them to.

In this code we can change the color of QR code according to our need, to chnage the color one need to chnage the color code from the source

In this i have used a dependency

dependencies 
{
compile 'com.journeyapps:zxing-android-embedded:3.4.0'
}

if you which to use the code then use the latest version of it.

Code to create OR code :

              String URL=str.getText().toString(); //string that you want to convert into OR code
              
                QRCodeWriter writer = new QRCodeWriter();
                try {
                    BitMatrix bitMatrix = writer.encode(URL, BarcodeFormat.QR_CODE, 512, 512); // 512 is the dimension of the QR code
                    int width = bitMatrix.getWidth();
                    int height = bitMatrix.getHeight();
                    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                    for (int x = 0; x < width; x++) {
                        for (int y = 0; y < height; y++) {
                            bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE); //default color used in the QR code, it change be change according to the user use
                        }
                    }
                    qr.setImageBitmap(bmp);

                } catch (WriterException e) {
                    e.printStackTrace();
                }
