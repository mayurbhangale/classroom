#include<iostream>
#include<stdlib.h>
using namespace std;

int main(){
  cout<<"Creating Ramdisk...\n\n";
  
  system("mkdir /mnt/ramdisk");
  system("mount -t tmpfs -o size=256M tmpfs /mnt/ramdisk");
  
  cout<<"Ramdisk created at /tmp/ramdisk/ "<<endl<<endl;
  cout<<"Total size available on ramdrive:\n";
  system("df -h /mnt/ramdisk");
  cout<<"\n\n";
  
  cout<<"Amount of Ramdrive used:\n";
  system("du -h /mnt/ramdisk/");
  system("cp calc.cpp /mnt/ramdisk");
  
  return 0;
}
