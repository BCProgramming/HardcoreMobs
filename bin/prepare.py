#!/usr/bin/env python
import sys,os,zipfile

def zipdir(path,rootfolder, zip):
    for root, dirs, files in os.walk(path,topdown=True):
        print(root,dirs,files)
        dirs[:] = [d for d in dirs if not (d.startswith(".") or d.startswith("_"))] 
        for dir in dirs:
            zipdir(os.path.join(root,dir),os.path.join(rootfolder,dir),zip)
        for file in files:
            if not (file.lower().endswith(("jar","zip")) or file.startswith(".") or file.startswith("_") or file==scriptfile()):
                print("adding file:" + file)
                #print(os.path.join(dirs[0],file))
                zip.write(os.path.join(root, file),os.path.join(rootfolder,file))
            else:
                print "Skipping file:" + file
        break
def scriptfile():
    dname,fname = os.path.split(os.path.abspath(sys.argv[0]))
    return fname
if __name__ == '__main__':
    print("main file:" + __file__)
    zip = zipfile.ZipFile('survivalchests.jar', 'w')
    usefolder = os.path.dirname(os.path.realpath(sys.argv[0]))
    zipdir(usefolder,"", zip)
    zip.close()