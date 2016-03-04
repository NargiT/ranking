# Volumes 
## Mount a folder in your the VirtualBox
By default it is configured on C:\Users and mount on /c/Users

## Mount a custom location
If you want to use a custom path, instead of the default one, you can add to the following to this file 
```/mnt/sda1/var/lib/boot2docker/profile```.

	mkdir -p /d/code  
	mount -t vboxsf -o uid=1000,gid=50 d/code /d/code
Here, `d/code` is the name that was given to the VirtualBox shared folder
# Sources
* http://blog.pavelsklenar.com/5-useful-docker-tip-and-tricks-on-windows/
* https://docs.docker.com