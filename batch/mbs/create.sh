#!/bin/bash
while IFS=":" read id text; do
   convert \
   -background transparent \
   -fill white \
   -font Droid-Sans \
   -size 96x96 \
   -gravity center \
   label:"$text\nMB/s" \
   $id.png
done < __resource_set.txt