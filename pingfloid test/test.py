import os, fnmatch
listOfFiles = os.listdir('server/public')
pattern = "*.*"
print(listOfFiles)
for entry in listOfFiles:
    if fnmatch.fnmatch(entry, pattern):
        print(entry)
print('close')