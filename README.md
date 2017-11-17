# EBookReader
A ebook reader uses Baidu Speech synthetise api to read ebook resources with a relatively natural accent

# Developing background
This days are pretty hard for me. I got Conjunctivitis these days and my eyes are always too tired to read books or write code.(After that, when I am writing this ReadMe file, I realize how I love writing codes. Two or three hours just pasts so quickly, theory of relativity, hum!) I can only be focuesed to read books or work on computers for only  3 or 4 hours per day.

My life are pretty hard in many different ways these days.
In order to fuck this situation, I start to develop this project which can read ebooks(first version will mainly focus on PDF format) in a computer synthetise accent. It can help me read ebooks while my eyes are too tired to do anything.

It now uses Ali's speech synthetise api to help me do the computer speech job soundly.
I'm working super hard this days. It's a hard time for me.

# Usage
It helps people who has trouble with their eyesight or people whose eye are too tired to read. It also helps people who are too shy to make a presentation :)(you write the text, then I help you read it!)

Input: an ebook's filepath

Output: audio file of the ebook.

# Why I develop the project?
It uses Ali's tts api which is better than the local os's tts engine in Chinese speacking.

# Development Architecture
The EbookReader now supports two main formats: PDF and Epub. I prefer the user to use the epub format. Cause some books of the PDF format are now clear in structure and thus hard to be processed by computer.

##To process Epub format file:

step1: cause it's based on Alibaba's online tts service, step1 will check the connectivity of the internet; if the network is ok, move to step2(some issues here).

step2: get context from Epub file(done, using Epublib). (done)

step3: the data we get above are html format data. So to get the real data, we need to do some thing on the html format data(not done).

step4: use Alibaba's speech synthetise api with the context and generate a wav format music.(done)

step5: play the music generated above(done).

step6: construct all the features to an initial product.(not done)


##To process PDF format file:

step1: cause it's based on Alibaba's online tts service, step1 will check the connectivity of the internet; if the network is ok, move to step2(some issues here).

step2: get context from pdf file(done, using PDFBox).

step3: use Alibaba's speech synthetise api with the context and generate a wav format music.(done)

step4: play the music generated above(done).

step5: construct all the features to an initial product.(not done)


#Issues
??????????
