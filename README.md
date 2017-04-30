# BatchTexter

This project shows how to generate image resources from text.



## Requirements

* ImageMagick (https://www.imagemagick.org/script/index.php)
    * Ensure that your Terminal / Console will know ImageMagick's commands.
    
* You may want to install Droid-Sans, which is the default font in Android. The .ttf files can be found in the [fonts](https://github.com/pepperonas/BatchTexter/fonts) directory of this repo.
     


## How it works

1. Generate text which will be batch-processed. [Main.java](https://github.com/pepperonas/BatchTexter/src/com/pepperonas/batchtexter/Main.java) can be used to get a processable text file. This [file](https://github.com/pepperonas/BatchTexter/batch/_resource_set.txt) shows a text which can be batch-processed. 
2. Set up the batch file. This [template](https://github.com/pepperonas/BatchTexter/batch/create.sh) gives you an idea. 
3. Run the batch file.
4. Compress / optimize. 



## Modifications

#### File Creation

Change generateContent() in [Main.java](https://github.com/pepperonas/BatchTexter/src/com/pepperonas/batchtexter/Main.java)

Percentage values
```
private static void generateContent() {
    System.out.println("Creating percentage asset");
    String content = loopPercentage("img_p###:###%", "###", 100);
    showInConsole(content);
    writeToFile("_resource_set.txt", content);
}
```

Byte values
```
private static void generateContent() {
    System.out.println("Creating percentage asset");
    String content = loopPercentage("img_b###:###B/s", "###", 1024);
    showInConsole(content);
    writeToFile("_resource_set.txt", content);
}
```

#### ImageMagick Parameters

```
   -background transparent \
   -fill white \
   -font Droid-Sans \
   -size 96x96 \
   -gravity center \
   label:"$text" \
   $id.png
```


## Notes

* The generated .png-files are not compressed. 
    Keep in mind that compressed files can be processed faster and will result in a better performance.
* The processable text file requires a linebreak at the end of the file.
* Since the amount of the characters varies, you will have to cherry-pick 
    the suitable images from the sub-folders you find in [batch/](https://github.com/pepperonas/BatchTexter/batch/) 
    manually. An other solution is telling ImageMagick to size the content automatically. However, the current output in [batch/](https://github.com/pepperonas/BatchTexter/batch/) 
    may be cut off. 


## In action

### M104 (Android)

 [Google Play](https://play.google.com/store/apps/details?id=com.pepperonas.m104&hl=en)
 
 [GitHub](https://github.com/pepperonas/M104)
 



## Android related

Since Android allows only .png-files in the status-bar this project provides a easy solution to show a very short text or a symbols by generating an image.

#### Sizes
```
22 × 22 area in 24 × 24 (mdpi)
33 × 33 area in 36 × 36 (hdpi)
44 × 44 area in 48 × 48 (xhdpi)
66 × 66 area in 72 × 72 (xxhdpi)
88 × 88 area in 96 × 96 (xxxhdpi)
```



## Contact

* Martin Pfeffer - https://celox.io - <martin.pfeffer@celox.io>



## License

    Copyright 2017 Martin Pfeffer

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.