include linux-yocto-common.inc

# default architecture configuration
SRC_URI_append_zynq   = " file://zynq-default-standard.scc"
SRC_URI_append_microblaze   = " file://microblaze-default-standard.scc"

