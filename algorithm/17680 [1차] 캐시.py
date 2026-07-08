def execute_time(cache: list, cache_size: int, city: int) -> int:
    if city in cache:
        if len(cache) >= cache_size and cache:
            cache.remove(city)
        if len(cache) < cache_size:
            cache.append(city)
        return 1
    if len(cache) >= cache_size and cache:
        del cache[0]
    if len(cache) < cache_size:
        cache.append(city)
    return 5
        
def solution(cacheSize: int, cities: list) -> int:
    answer = 0
    cache = []
    for city in cities:
        answer += execute_time(cache, cacheSize, city.lower())
    return answer