#!/bin/bash

# 恢复正常模式
# 需使用 sudo 运行: sudo ./normal_mode.sh

echo "正在恢复性能模式..."

# 1. 获取 CPU 最大理论频率并解除限制
MAX_FREQ=$(cat /sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq)
cpupower frequency-set -u "${MAX_FREQ}kHz" > /dev/null 2>&1

# 2. 恢复能源偏好为平衡性能
for i in /sys/devices/system/cpu/cpu*/cpufreq/energy_performance_preference; do
    echo "balance_performance" > "$i"
done

# 3. 重新开启 Intel 睿频 (Turbo Boost)
echo 0 > /sys/devices/system/cpu/intel_pstate/no_turbo

# 4. 切换 tuned 配置为平衡 (或你常用的配置)
tuned-adm profile balanced > /dev/null 2>&1

echo "性能已恢复！"
