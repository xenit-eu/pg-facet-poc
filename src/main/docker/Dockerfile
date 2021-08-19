FROM docker.io/xenit/postgres:13

RUN   apt-get update \
      && apt-get -y install curl postgresql-server-dev-13 build-essential\
      && cd /tmp \
      && curl -LkSs https://api.github.com/repos/hyperstudio/repertoire-faceting/tarball -o master.tar.gz \
      && tar -xzf master.tar.gz \
      && cd hyperstudio-repertoire-*/ext \
      && make; make install \
      && apt-get -y remove curl postgresql-server-dev-13 build-essential && apt-get -y autoremove \
      && rm -rf /var/lib/apt/lists/* \
      && rm -rf /tmp/*

