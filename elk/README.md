Running in WSL
Run as separate container, if not get errors in filebeat

WSL need to mount directory

# create missing docker sub-folder
sudo mkdir /mnt/wsl/docker-desktop-data/data/docker

# mount as readonly with 755 permissions
sudo mount -t drvfs '\\wsl$\docker-desktop-data\version-pack-data\community\docker' /mnt/wsl/docker-desktop-data/data/docker -o ro,umask=022

need to chown to root filebeat/filebeat.docker.yml
chown root {beatname}.yml

elastic search directory Access Denied
sudo chown -R 1000:1000 [directory]
