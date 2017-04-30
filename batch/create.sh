#!/bin/bash
while IFS=":" read id text; do
   convert -size 96x96 xc:transparent -fill white -pointsize 36 -gravity center -draw "text 0,0 '$text'" $id.png
done < _resource_set.txt